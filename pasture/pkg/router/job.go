package router

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func (router *router) JobRoute() *router {
	router.R.GET("/jobs", func(c *gin.Context) {
		jobs := jobService.GetJobs()

		c.JSON(http.StatusOK, gin.H{"jobs": jobs})
	})
	return router
}
