package menu

import data.Food

class MenuService():Menu{
    override val foodList: HashMap<String, MutableList<Food>> = hashMapOf()

    override fun printMenu(category: String) {
        println("[$category]")
        for (food in foodList[category]!!) {
            println("${food.index}. ${food.name} | W ${food.price} | ${food.comment}")
        }
        println("0. 뒤로가기")

    }

    override fun printCategory() {
        println("아래 메뉴판을 보시고 메뉴 번호를 입력해 주세요.")
        println("[ 메인 메뉴 ]")
        foodList.keys.mapIndexed { index, categoryFood ->
                println("${index+1}. $categoryFood")
        }
        println("0. 종료")
    }

    override fun setMenu(category:String, food: Food) {
       foodList[category]!!.add(Food(food.index, food.name, food.price, food.comment))
    }

    override fun setCategory(category: String) {
        foodList[category] = mutableListOf()
        // 기존에 있는 category 예외 생각하기
    }
}
