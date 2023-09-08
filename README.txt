B.  Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
    1. mainscreen.html, line 14: Changed "My Bicycle Shop" to "Creative Bites Bakery".
    2. mainscreen.html, line 19: Changed "Shop" to "Creative Bites Bakery".
    3. Added parts and products via the interface.

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
    1. AboutController.java, lines 1-4: added imports for packages needed.
    2. AboutController.java, line 6: added @Controller annotation.
    3. AboutController.java, line 7: added AboutController class.
    4. AboutController.java, line 8: added @GetMapping("/about").
    5. AboutController.java, lines 9-10: added method about() that returns "about" when called.
    6. about.html, lines 1-9 and 14-15: created file and added boilerplate html code.
    7. about.html, lines 6-7: added Bootstrap CDN link
    8. about.html, line 10: added h1 element for title of page
    9. about.html, lines 11-12: added p element that describes customer's company to viewer.
    10. about.html, line 13: added navigation to main page.
    11. mainscreen.html, line 20: added navigation to about page.

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
    1. InhousePart.java, lines 19-22: Added constructor method that called super to add id, part name, price, and inventory amount.
    2. OutsourcedPart.java, lines 19-23: Added constructor method that called super to add id, part name, price, and inventory          amount. In addition, constructor also sets company name of part.
    3. BootStrapData.java, line 3: imported InhousePart.java.
    4. BootStrapData.java, line 7: imported InhousePartRepository.java
    5. BootStrapData.java, lines 34, 36, 40: added InhousePartRepository to constructor and assigned it to added private variable.
    6. BootStrapData.java, lines 62-71: Adds 3 in house parts to InhousePartRepository if there's no parts to begin with.
    7. BootStrapData.java, lines 72-79: Adds 2 outsourced parts to OutsourcedPartRepository if there's no parts to begin with.
    8. BootStrapData.java, lines 91-103: Adds 5 products to ProductRepository if there's no products to begin with.

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•   The “Buy Now” button must be next to the buttons that update and delete products.
•   The button should decrement the inventory of that product by one. It should not affect the inventory of the associated parts.
•   Display a message that indicates the success or failure of a purchase.
    1. mainscreen.html, line 86: Added button next to update and delete that is mapped to "buyProduct" in MainScreenControllerr.java. Also sent product id.
    2. confirmationbuy.html, lines 1-9 and 14-15: created file and added boilerplate html.
    3. confirmationbuy.html, line 10: added h1 element for confirmation of purchase.
    4. confirmationbuy.html, lines 12-13: added link back to main page.
    5. MainScreenControllerr.java, line 13: imported RequestParam to receive productId in method boughtProduct.
    6. MainScreenControllerr.java, line 27: uncommented productRepository variable.
    7. MainScreenControllerr.java, line 40: added productRepository parameter to MainScreenController constructor.
    8. MainScreenControllerr.java, line 43: assigned productRepository variable to local private productRepository variable.
    9. MainScreenControllerr.java, line 58: added GetMapping for boughtProduct from mainscreen.html.
    10. MainScreenControllerr.java, line 59: added method boughtProduct with parameters theId, which is the argument passed from mainscreen.html, and theModel.
    11. MainScreenControllerr.java, line 60: used productService with findById method to assign product to variable boughtItem.
    12. MainScreenControllerr.java, lines 62-64: used getInv, used setInv to decrement 1 from inventory, and finally saved the product back into productRepository. If inventory less than one, returned "error" to show error webpage.
    13. MainScreenControllerr.java, line 66: returned "confirmationbuy" to mainscreen.html to confirm purchase with confirmationbuy webpage.
    14. error.html, lines 1-7 and 12-13: created file and added boilerplate html.
    15. error.html, line 8: added h1 element for failure of purchase due to insufficient inventory.
    16. error.html, lines 10-11: added link back to main page.

G. Modify the parts to track maximum and minimum inventory by doing the following:
•   Add additional fields to the part entity for maximum and minimum inventory.
•   Modify the sample inventory to include the maximum and minimum fields.
•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•   Rename the file the persistent storage is saved to.
•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.
    1. BootStrapData.java, lines 64, 66, 68, 74, 76: Modified sample inventory to include minimum and maximum values.
    2. InhousePart.java, lines 20-22: Modified InhousePart constructor parameters to take in minimum and maximum values. Updated call to super constructor to add minimum and maximum values. Assigned id to local partId.
    3. OutsourcedPart.java, lines 20-21: Modified OutsourcedPart constructor parameters to take in minimum and maximum values. Updated call to super constructor to add minimum and maximum values.
    4. Part.java, lines 4-5: Imported validators ValidMinInventory and ValidMaxInventory.
    5. Part.java, lines 24-25: Added ValidMinInventory and ValidMaxInventory annotations.
    6. Part.java, lines 36-38: Added new column minVal for minimum value with @Column and @Min annotations.
    7. Part.java, lines 39-41: Added new column maxVal for maximum value with @Column and @Min annotations.
    8. Part.java, lines 57, 62-63: Added minVal and maxVal in constructor parameters and assigned them to local variables.
    9. Part.java, lines 106-121: Added getter and setter methods for minVal and maxVal.
    10. application.properties, line 6: Changed persistent storage file to ~/spring-boot-h2-db103.
    11. MaxInventoryValidator.java, lines 1-26, 38: Created class and added boilerplate validator code.
    12. MaxInventoryValidator.java, lines 27-37: added override to isValid method which includes an if statement to check if part inventory value is less than or equal to max value and appended error to minVal field if needed.
    13. MinInventoryValidator.java, lines 1-26, 38: Created class and added boilerplate validator code.
    14. MinInventoryValidator.java, lines 28-35: added override to isValid method which includes an if statement to check if part inventory value is greater than or equal to min value and appended error to minVal field if needed.
    15. ValidMaxInventory.java, lines 1-17: Created annotation class and added boilerplate code.
    16. ValidMinInventory.java, lines 1-17: Created annotation class and added boilerplate code.
    17. InhousePartForm.html, lines 16, 18, 21, 24: Added field names to p elements.
    18. InhousePartForm.html, lines 25-30: Added input fields for minimum inventory and maximum inventory.
    19. mainscreen.html, lines 39-40: Added Maximum Inventory and Minimum Inventory titles to table.
    20. mainscreen.html, lines 49-50: inserted data from tempPart for minimum and maximum values into table.
    21. OutsourcedPartForm.html, lines 17, 19, 22, 25: Added field names to p elements.
    22. OutsourcedPartForm.html, lines 25-31: Added input fields for minimum inventory and maximum inventory.

H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
•   Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•   Display error messages when adding and updating parts if the inventory is greater than the maximum.
    1. MainScreenControllerr.java, line 63: Updated return error to failure for updated html page.
    2. EnufPartsValidator.java, line 36: Updated if condition to compare difference between part inventory, minimum value and compare it to difference between number in field and prior inventory.
    3. ValidEnufParts.java, line 20: Updated message error string to mention not going under part minimum inventory.
    4. ValidMaxInventory.java, line 14: Updated message error string to mention not going over part maximum inventory.
    4. ValidMinInventory.java, line 14: Updated message error string to mention not going under part minimum inventory.
    5. failure.html, filename: Updated name from "error" to "failure".
    6. productForm.html, line 74-75: Added link back to main page to productForm.

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
    1. PartTest.java, lines 159-167: added unit test to set minimum fields in partIn and partOut.
    1. PartTest.java, lines 168-176: added unit test to get minimum fields in partIn and partOut.
    1. PartTest.java, lines 177-185: added unit test to set maximum fields in partIn and partOut.
    1. PartTest.java, lines 186-194: added unit test to get maximum fields in partIn and partOut.

J.  Remove the class files for any unused validators in order to clean your code.
    1. Removed DeletePartValidator.java and ValidDeletePart.java.
    2. Part.java, line 19: Removed annotation @ValidDeletePart.