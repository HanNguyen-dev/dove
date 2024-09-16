package dataaccess

import (
	"fmt"
	"os"

	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var (
	dbuser     = os.Getenv("dbuser")
	dbpassword = os.Getenv("dbpassword")
	dsn        = fmt.Sprintf(
		"host=127.0.0.1 user=%s password=%s dbname=jobs port=5432 sslmode=disable TimeZone=US/Eastern",
		dbuser,
		dbpassword,
	)
)

type Repo struct {
	Db *gorm.DB
}

var repo *Repo

func GetInstance() *Repo {
	if repo == nil {
		db, err := gorm.Open(postgres.Open(dsn), &gorm.Config{})

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
