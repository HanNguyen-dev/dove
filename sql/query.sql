USE jobs;

SELECT job.title AS Title
FROM job
INNER JOIN company ON job.company_id = company.company_id
INNER JOIN industry ON company.industry_id = company.company_id;