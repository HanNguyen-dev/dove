package domain

type ICompanyService interface {
	GetCompanies() []Company
}

type IJobService interface {
	GetJobs() []Job
}
