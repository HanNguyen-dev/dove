package dataaccess

import (
	"fmt"
	"os"

	"gorm.io/driver/mysql"
	"gorm.io/gorm"
)

var (
	dbuser     = os.Getenv("dbuser")
	dbpassword = os.Getenv("dbpassword")
	dsn        = fmt.Sprintf("%s:%s@tcp(127.0.0.1:3306)/jobs?charset=utf8mb4&parseTime=True&loc=Local", dbuser, dbpassword)
)

type Repo struct {
	Db *gorm.DB
}

var repo *Repo

func GetInstance() *Repo {
	if repo == nil {
		db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})

		if err != nil {
			panic(err)
		}

		repo = &Repo{
			Db: db,
		}
		return repo
	}
	return repo
}
