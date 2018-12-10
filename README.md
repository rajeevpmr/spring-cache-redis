# Cache Demo with Spring and Redis

This is a sample project to demonstrate how to cache your repository using Spring and Redis. For simplicity, I have used H2 database and a hypothetical scenario of Customer.

<h1> Pre-Requisites </h1>

<p> <ul> 
<li> 
	Install Redis in your local machine
</li>
</ul>

<h1> How to test? </h1>

Sample data is a loaded using CommandLineRunner.

localhost:9090/customer/3

First time, when you access this data you will see an Info log stating that <i> "Retrieving customer details for 3" </i> and next time when you hit the same URL you wont see that message because it is getting fetched from Redis

In youre Redis console, 

<code>
> KEYS *
</code>

This should give you all the cached keys
