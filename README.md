<h1>CSC 340 Assignment 5 : feature-MVC</h1>

<p>This assignment showcases connecting to a MySQL database called animal, and a table called animal. In the previous version of this code, we were using a RestController, but we are now using a Controller from the Springboot framework. 
</p>

<br>

<h2>Viewing the full list of animals</h2>
<pre>
  To display all animals, enter the following url:
  'localhost:8080/animal/all'
</pre>

This is the main page for this small demo. There is a link at the top to creating an animal, as well as one to the "All Animals" page. Each listed animal in the table contains a link to view the specific animal, edit the animal, and delete the animal. 

<h2>Creating an animal</h2>
<pre>
  To create a new animal, enter the following url:
  'localhost:8080/animal/create'
</pre>

This page contains all non-generated animal attributes to be filled in (name, species, habitat, scientific name, and description). When completed, hit save and the page will be redirected to the "All Animals" page where you will see the newly created animal.

<h2>Updating Animals</h2>
<pre>
  To update an animal, enter the following url:
  'localhost:8080/update-form/{animalId}'
</pre>

This form displays all animal information, but the animalId is set to readonly. When completed, hit save and the page will update in the backed and redirect to the details page for that specific animal.

<h2>Deleting Animals</h2>
<pre>
  Deleting an animal is handled with a link from "All Animals" 
  and "Animal Details" pages, but the link to do so is as follows:
  'localhost:8080/delete/{animalId}'
</pre>

This link redirects you to the "All Animals" page. 
