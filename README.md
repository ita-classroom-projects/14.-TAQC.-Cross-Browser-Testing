# 14. Cross Browser Testing


1. Realize inner classes for creating an instance of needed driver in Browsers class 
2. In RegexUtils class write regular expressions for finding digits in the string
3. In **BrowsersTest** class create methods  
   a.	**checkListGroups** – for checking accurate amount of products in a group. Run this test in different browsers. Find links using By.linkText and By.partialLinkText.
![image](https://user-images.githubusercontent.com/22353523/129970860-d2516318-df30-49ef-9074-2faf312845bf.png)   
 

b. **checkSearchCounts** – for checking an amount of finding items in simple search in different browsers
For example, in a case   
![image](https://user-images.githubusercontent.com/22353523/129970909-7d494f6e-b932-4535-a0ff-611ad0ec7e49.png)   


You have to check that 6 items are returned.
![image](https://user-images.githubusercontent.com/22353523/129970964-c4b66977-ca23-4391-8796-b9f4ff1a06ce.png)   


c. **checkAdvancedSearchCounts** – to check an amount of finding items in case of extended search with selection of some category. For example, if user enters `ip’ in ‘Search’ field, selects any category and clicks on ‘Search’ button he/she has to receive two products

![image](https://user-images.githubusercontent.com/22353523/129971036-ee854d81-8c5a-43c7-a0ac-3597d9492af5.png)   
