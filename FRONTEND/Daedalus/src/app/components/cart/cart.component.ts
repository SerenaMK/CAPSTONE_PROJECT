import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import { ProductsService } from 'src/app/services/products.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

    localUser: any = JSON.parse(localStorage.getItem("user")!)
    user: any
    oh: any
    cart: any
    products: any = []
    total: number = 0

    constructor(private userService: UserService, private productService: ProductsService, private orderService: OrderService) { }

    ngOnInit(): void {

        this.userService.getUserById(this.localUser.id).subscribe(data => {
            this.user = data
            this.products = this.user.account.cart.products
            this.cart = this.user.account.cart
            this.oh = this.user.account.orderHistory


            ////////////////////////////////
            let filtered: string | any[] = []
            let ids: number[] = []

            console.log("-------------------------------------");

            for (let i = 0; i < this.products.length; i++) {
                let thisid = this.products[i].id

                if (!ids.includes(thisid)) {
                    ids.push(thisid)
                    this.products[i].quantity = 1;
                    filtered.push(this.products[i])
                } else {

                    let theOne: number = 30

                    for (let i = 0; i < filtered.length; i++) {
                        if (filtered[i].id == thisid) {
                            theOne = i
                        }
                    }

                    // console.log("index of the one to add quantity to:");
                    // console.log(theOne);

                    filtered[theOne].quantity += 1;
                }
            }
            this.products = filtered
            ////////////////////////////////

            for (let i = 0; i < this.products.length; i++) {
                let priceSum = this.products[i].price * this.products[i].quantity

                this.total += priceSum
            }
        })
    }

    proceedToCheckout() {
        // let body
        // let cartTemp = this.cart

        // for (let i = 0; i < cartTemp.products.length; i++) {
        //     delete cartTemp.products[i].quantity
        // }

        // body = {
        //     "oh": this.oh,
        //     "cart": cartTemp
        // }

        this.orderService.addOrder(this.oh.id, this.cart.id).subscribe(data => {
            let orderCreated
            console.log("Order created. Maybe.");
            orderCreated = data
            console.log(orderCreated);
        })
    }
}
