package router

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/hannguyen-dev/dove/pasture/pkg/domain"
	"github.com/hannguyen-dev/dove/pasture/pkg/service"
)

var (
	db                                    = make(map[string]string)
	companyService domain.ICompanyService = service.NewCompanyService()
	jobService     domain.IJobService     = service.NewJobService()
)

type router struct {
	R *gin.Engine
}

func SetupRouter() *router {
	r := gin.Default()

	// Ping test
	r.GET("/ping", func(c *gin.Context) {
		c.String(http.StatusOK, "pong")
	})

	// Get user value
	r.GET("/user/:name", func(c *gin.Context) {
		user := c.Params.ByName("name")
		value, ok := db[user]
		if ok {
			c.JSON(http.StatusOK, gin.H{"user": user, "value": value})
		} else {
			c.JSON(http.StatusOK, gin.H{"user": user, "status": "no value"})
		}
	})

	return &router{
		R: r,
	}
}
