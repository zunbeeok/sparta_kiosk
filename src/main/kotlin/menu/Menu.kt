package menu

import food.Food


interface Menu{
    // 메모리로 보관하는 메뉴 내역.
    val foodList:HashMap<String,List<Food>>;

    //메뉴를 조회한다.
    fun getMenu(category:String):List<Food>;

    //카테고리를 조회한다.
    fun getCategory():List<String>;

//    fun setMenu();

//    fun setCategory();
}
