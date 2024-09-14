package domain

import "time"

type Company struct {
	CompanyId   int    `json:"companyId"`
	Name        string `json:"name"`
	Headquarter string `json:"headquarter"`
	Industry    string `json:"industry"`
}

type Job struct {
	JobId         int       `json:"jobId"`
	Title         string    `json:"title"`
	Frontend      string    `json:"frontend"`
	Backend       string    `json:"backend"`
	StoreDb       string    `json:"storeDb"`
	Cloud         string    `json:"cloud"`
	Languages     string    `json:"languages"`
	Experience    string    `json:"experience"`
	AppliedDate   time.Time `json:"appliedDate"`
	CompletedDate time.Time `json:"completedDate"`
	Status        string    `json:"status"`
	CompanyName   string    `json:"companyName"`
	Url           string    `json:"url"`
}
