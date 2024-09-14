package router

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func (router *router) CompanyRoute() *router {
	router.R.GET("/companies", func(c *gin.Context) {
		companies := companyService.GetCompanies()

		c.JSON(http.StatusOK, gin.H{"companies": companies})
	})
	return router
}
