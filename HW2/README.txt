* Team1  homework2

* 自動化build: 移至build.xml該目錄下 在命令提示元打 ant main  (ant指令會需要設定系統path參數，java compiler位置也會需要)
	

* 需加入外部library檔案: "jsoup-1.7.3.jar"


* 

Design Pattern : Simple Factory

Purposes:

	‧ 主要目的是想將所有物件產出的功能，集中在一個class去定義，而不是散亂在程式碼各處。
	‧ 之後如果要parser的網頁增加時，不需要修改其他class，只要新增產出的物件部分的程式碼就可以。


Design Pattern : Iterator


Purposes:

	‧因為無論是List或Set，都繼承Collection介面，所以不需要考慮容器底層的類型。
	‧現在是用ArrayList，如之後容器更換，此程式碼不須更動。


