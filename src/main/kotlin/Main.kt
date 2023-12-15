import cart.CartService
import data.Food
import enum.BankList
import menu.MenuService
import order.OrderService
import payment.PaymentService

fun main(args: Array<String>) {
    
//    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
    val menuService=MenuService();
    val cartService=CartService();
    val orderService=OrderService(PaymentService());
    init(menuService);
    while (true) {
        startUpScreen(menuService, cartService,orderService);
    }

}

fun startUpScreen(menuService:MenuService,cartService:CartService,orderService: OrderService){
    println("김밥천국에 오신걸 환영합니다.");

    println(" 1. 등록하기")
    println(" 2. 영업하기")
    println();

    val input = readLine()!!;
    if(input == "1"){
        uploadScreen(menuService);
        return; // 업로드구현 안해놔서 이런겁니다.
    }else if(input == "2"){
        saleScreen(menuService,cartService);
    }else{
        println("잘못 입력하였습니다. 프로그램을 종료합니다.");
        return;
    }

    println("이대로 주문하시겠습니까?")
    orderService.printCartList(cartService.cartList);
    
    println("1. 확인           2. 취소")
    val orderConfirmStatus=readLine()!!;

    if(orderConfirmStatus=="2"){
        //주문목록에서 취소할수 있겠끔 추가 작업 필요.
        return;
    }
    orderService.printOrderToTalPrice(cartService);

    while (true) {
        println("결제 방법을 선택해주세요.")
        println("1. 카카오페이           2. 네이버페이              3. 신용카드      4. 초기화면으로 돌아가기");
        val paymentMethod = readLine()!!

        val paymentMethodToString = when (paymentMethod) {
            "1" -> BankList.카카오페이;
            "2" -> BankList.네이버페이;
            "3" -> BankList.신용카드;
            "4" -> return;
            else -> null;
        }

        if (paymentMethod == null) {
            println("결제방법 선택이 잘 못 되었습니다.")
            continue;
        }


        println("${paymentMethodToString}로 결제하겠습니다.")

        orderService.purchase(paymentMethodToString!!);
        break;

    }

    println("주문이 정상적으로 완료 되었습니다. 초기화면으로 돌아갑니다.")



}

fun uploadScreen(menuService:MenuService){
    println("현재 등록하기는 구현되어 있지 않습니다. 최초로 돌아갑니다.")
//    var status =true;
//    while (status){
//        linePrint();
//        println(" 1. 등록하기")
//        println(" 2. 목록 조회하기.")
//        println(" 3. 이전으로 돌아가기.")
//        linePrint();
//
//        var endStatus=readLine()!!
//
//        when(endStatus){
//            "1" -> saleScreen(menuService);
//            "2" -> getListScreen(menuService);
//            "3" ->status=false;
//            else -> println("잘 못 입력하였습니다.")
//        }
//
//        if(endStatus == "3"){
//            status=false;
//        }
//    }

}

fun saleScreen(menuService:MenuService,cartService: CartService){
    linePrint();
    while (true){
        menuService.printCategory();
        println("0. 뒤로가기")
        val input = readLine()!!
        if(input=="0"){
            return;
        }

    //    ["김밥","식사","음료","분식","라면"]
        val categoryList:List<String> =menuService.foodList.keys.toList();
        val category =categoryList[input.toInt()-1];
        if(categoryList.contains(category)){
            menuService.printMenu(category);
        }
        println("0. 뒤로가기")
        val status =readLine()!!

        if(status == "0"){
            return;
        }


        val checkStatus=true;
        menuSelect@while (checkStatus){
//        while (checkStatus){
            val menuList = menuService.getMenuList(category);
            val menu = menuList[(status.toInt()-1)];
            println("${menu.index}. ${menu.name} | W ${menu.price} | ${menu.comment}")
            println("위 메뉴를 추가하시겠습니까?");
            println("1. 확인       2. 취소");

            val checkMenu = readLine()!!;
            if(checkMenu == "2"){
                return; //일단은 종료 하지만 MENU선택으로 돌아가야한다.
            }else{
                cartService.addCart(menu,1);
                println("1. 메뉴선택     2. 계산하기")
                val checkContinueOrderStatus = readLine()!!;
                if(checkContinueOrderStatus == "1"){
                    break@menuSelect;
//                    break;
                }else{
                    return;
                }

            }
        }
    }

}

fun getListScreen(menuService:MenuService){

}
fun linePrint(){
    println(" ======================================================== ")
}

fun init(menuService: MenuService){
    menuService.setCategory("김밥")
    menuService.setMenu("김밥", Food(1,"일반김밥",30,"일반 김밥."));
    menuService.setMenu("김밥", Food(2,"참치김밥",35,"참치가 들어간 김밥."));
    menuService.setMenu("김밥", Food(3,"멸치김밥",35,"멸치가 들어간 김밥."));
    menuService.setMenu("김밥", Food(4,"키토김밥",40,"밥 대신 계란지단이 들어간 김밥."));
    menuService.setMenu("김밥", Food(5,"꼬마김밥",50,"작지만 비싼 꼬마김밥."));


    menuService.setCategory("분식")
    menuService.setMenu("분식", Food(1,"떡볶이",30,"일반적인 떡볶이 입니다."));
    menuService.setMenu("분식",Food(2,"짜장 떡볶이",40,"짜장소스로 만든 떡볶이 입니다."));
    menuService.setMenu("분식",Food(3,"어묵", 30, "부산 어묵을 익혀서 만든 어묵"));
    menuService.setMenu("분식",Food(4,"모듬 튀김", 80, "고구마, 김말이, 오징어, 야채가 들어간 모듬 튀김"))

    menuService.setCategory("라면")
    menuService.setMenu("라면",Food(1,"일반 라면",30,"신라면으로 만든 라면"));
    menuService.setMenu("라면",Food(2,"해장 라면",60,"각종 별미가 들어간 속풀이 용 라면"));
    menuService.setMenu("라면",Food(3,"떡 라면",50,"떡이 들어간 라면"));
    menuService.setMenu("라면",Food(4,"치즈 라면",50,"치즈가 들어간 라면"));
    menuService.setMenu("라면",Food(5,"점보 라면",150,"라면 5개가 들어간 라면 "));
    
    menuService.setCategory("식사")
    menuService.setMenu("식사", Food(1,"제육볶음", 80, "남자들이 좋아하는 1순위 제육볶음"))
    menuService.setMenu("식사",Food(2,"돈까스", 80, "남자들이 좋아하는 1순위 돈까스"))
    menuService.setMenu("식사",Food(3,"김치 볶음밥", 70, "승상님이 좋아하는 김치볶음밥"))
    
    menuService.setCategory("음료")
    menuService.setMenu("음료", Food(1,"콜라",30, "코카콜라"))
    menuService.setMenu("음료",Food(2,"사이다",30, "칠성 사이다"))
}