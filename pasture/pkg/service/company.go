package service

import (
	"github.com/hannguyen-dev/dove/pasture/pkg/dataaccess"
	"github.com/hannguyen-dev/dove/pasture/pkg/domain"
)

type CompanyService struct {
	tableName string
	repo      *dataaccess.Repo
}

func (cs *CompanyService) GetCompanies() []domain.Company {
	var companies []domain.Company
	cs.repo.Db.Table(cs.tableName).Find(&companies)
	return companies
}

func NewCompanyService() *CompanyService {
	return &CompanyService{
		tableName: "company",
		repo:      dataaccess.GetInstance(),
	}
}
