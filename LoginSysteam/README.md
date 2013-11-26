LoginSystem
===========
User Data structure:
 - Username
 - uUID( Generated from Hash )
 - Password

User data is managed by arraylist, functions is provided below:
 - pushAnElement: push a user structure to the list
 - deleteAnElement: delete a user structure from the list
 - checkAnElement: check if the specified user structure is in the list
 - saveList: save the list to a single file
 - loadList: load the list from a single file

Provide user command to manage the data:
 - /login: call checkAnElement
 - /register: call pushAnElement
 - /list: return who is online