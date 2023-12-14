package cart

import data.Food


class CartService: Cart {




  override val cartList: ArrayList<Food>  = arrayListOf()

    override fun addCart(food: Food, count: Int): List<Food> {

        for ( i in 1..count){
            cartList.add(food)
        }

        return  cartList
    }

    override fun deleteCart(index: Int): List<Food> {

        cartList.removeAt(index)

        return  cartList
    }

    //인덱스 별로 요소 삭제

    override fun getCartList(): List<Food> {
        return  cartList
    }

    override fun getTotalPrice(): Int {

        val totalPrice = 0

           for (a in cartList){
               totalPrice += a
           }


        }

    override fun totalDeleteCart() {
        cartList.clear()
    }




// 장바구니 출력 기능 , get 오더리스트 리스트 선언, 리스트 추가, 삭제



}