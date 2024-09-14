package service

import (
	"github.com/hannguyen-dev/dove/pasture/pkg/dataaccess"
	"github.com/hannguyen-dev/dove/pasture/pkg/domain"
)

type IJobService interface {
	GetJobs() []domain.Job
}

type JobService struct {
	tableName string
	repo      *dataaccess.Repo
}

func (js *JobService) GetJobs() []domain.Job {
	var jobs []domain.Job
	js.repo.Db.Table(js.tableName).Find(&jobs)
	return jobs
}

func NewJobService() *JobService {
	return &JobService{
		tableName: "job",
		repo:      dataaccess.GetInstance(),
	}
}
