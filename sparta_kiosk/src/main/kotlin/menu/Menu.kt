package menu

import data.Food


interface Menu{
    // 메모리로 보관하는 메뉴 내역.
    val foodList:HashMap<String,List<Food>>;

    //메뉴를 출력한다.
    fun printMenu(category:String):Unit;

    //카테고리를 출력한다.
    fun printCategory():Unit;

//    fun setMenu();

//    fun setCategory();
}
