# E-Invoice-System
A fresher DXC project

Project: E-Invoice System

1.Description

E-Invoice is built for the purpose of monthly invoice management in a family. It helps us to have an overall report of monthly expenses so that user could make plan to save money. User could set an alert for a limited amount of money consumed every month. Each invoice will have following information: 
•	Type of invoice: Electric, internet, telephone, water, ... 
•	Amount of money. 
•	VAT 
•	Charged period (monthly). 
•	Invoice No. 
•	Customer code (optional).

2.Functional Specification 

•	Users:

o	Register account.

o	CRUD services.

o	CRUD invoice consumed by a service.

o	View expenses report: Monthly, Yearly, or a period of time.

o	View charts: Bar chart, Pie chart (students should think about the details).

o	Set the monthly limited expenses for notification (via email).

•	Admin:

o	Activate/Deactivate a user account.

o	Configure the trigger point of time for running scheduled job to send email for monthly notification to each user if their monthly expenses exceed the pre-set limited amount of money. 

•	System constrains: 

o	Check duplication of monthly invoice when adding an invoice.

o	Able to send email for monthly notification to every user at trigger time (using POP3). 
