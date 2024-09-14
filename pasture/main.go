package main

import "github.com/hannguyen-dev/dove/pasture/pkg/router"

func main() {
  r := router.SetupRouter().CompanyRoute().JobRoute()
  r.R.Run()
}
