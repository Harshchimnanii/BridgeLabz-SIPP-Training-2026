-- Use Case 1: Find Highest Confirmed Cases using INNER JOIN
-- Retrieve the country with the highest number of confirmed COVID cases on a specific date.
-- Replace '2024-01-01' with the desired date.

SELECT c.country_name,
       cc.date_reported,
       cc.confirmed_cases
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
WHERE cc.date_reported = '2024-01-01'
ORDER BY cc.confirmed_cases DESC
LIMIT 1;

-- Use Case 2: Join COVID Deaths and Vaccination Data
-- Show death counts and vaccination status for all countries, including those missing vaccine data.

SELECT d.country_id,
       d.date_reported,
       d.death_count,
       v.vaccine_status
FROM covid_deaths d
LEFT JOIN covid_vaccines v
       ON d.country_id = v.country_id
          AND d.date_reported = v.date_reported;

-- Use Case 3: Analyze Deaths by Continent
-- Aggregate total deaths by continent.

SELECT t.continent,
       SUM(d.death_count) AS total_deaths
FROM covid_cases d
INNER JOIN continents t
    ON d.country_id = t.country_id
GROUP BY t.continent
ORDER BY total_deaths DESC;

-- Use Case 4: Calculate Average New Deaths Per Day
-- Track the global trend of average daily deaths ordered by date.

SELECT date_reported,
       AVG(death_count) AS average_daily_deaths
FROM covid_deaths
GROUP BY date_reported
ORDER BY date_reported;

-- Use Case 5: Find Countries with Highest Infection Rates
-- Calculate infection rate and rank countries.

SELECT c.country_name,
       cc.date_reported,
       cc.confirmed_cases,
       c.population,
       (cc.confirmed_cases * 100.0 / c.population) AS infection_rate
FROM covid_cases cc
INNER JOIN countries c
    ON cc.country_id = c.country_id
ORDER BY infection_rate DESC;
