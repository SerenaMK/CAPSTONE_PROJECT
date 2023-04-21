import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderHistoryService } from 'src/app/services/order-history.service';
import { OrderService } from 'src/app/services/order.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

    user: any
    cartProducts: any
    favesProducts: any
    orderHistory: any
    orders: any
    ordersFull: any[] = []
    total: number = 0

    constructor(private userService: UserService, private ohService: OrderHistoryService, private orderService: OrderService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.userService.getUserById(this.userService.localUser.id).subscribe(data => {
            this.user = data
            this.cartProducts = this.user.account.cart.products
            this.favesProducts = this.user.account.favorites.products

            ///////////////CART FILTER/////////////////
            let filtered: string | any[] = []
            let ids: number[] = []

            for (let i = 0; i < this.cartProducts.length; i++) {
                let thisid = this.cartProducts[i].id

                if (!ids.includes(thisid)) {
                    ids.push(thisid)
                    this.cartProducts[i].quantity = 1;
                    filtered.push(this.cartProducts[i])
                } else {

                    let theOne: number = 0

                    for (let i = 0; i < filtered.length; i++) {
                        if (filtered[i].id == thisid) {
                            theOne = i
                        }
                    }

                    filtered[theOne].quantity += 1;
                }
            }

            this.cartProducts = filtered

            ////////////////////////////////

            for (let i = 0; i < this.cartProducts.length; i++) {
                let priceSum = this.cartProducts[i].price * this.cartProducts[i].quantity

                this.total += priceSum
            }

            this.ohService.getOrderHistoryById(this.user.account.orderHistory.id).subscribe(data => {
                this.orderHistory = data
                this.orders = this.orderHistory.orders

                ///////////////ORDER PRODUCTS FILTER/////////////////
                console.log("-------------------------------------");

                for (let j = 0; j < this.orders.length; j++) {
                    let filtered: any[] = []
                    let ids: number[] = []

                    for (let i = 0; i < this.orders[j].products.length; i++) {
                        let thisid = this.orders[j].products[i].id

                        if (!ids.includes(thisid)) {
                            ids.push(thisid)
                            this.orders[j].products[i].quantity = 1;
                            filtered.push(this.orders[j].products[i])
                        }
                        else {
                            let theOne: number = 0
                            for (let k = 0; k < filtered.length; k++) {
                                if (filtered[k].id == thisid) {
                                    filtered[k].quantity += 1;
                                }
                            }
                        }
                    }

                    this.orders[j].products = filtered
                }

                console.log("-------------------------------------");
                ////////////////////////////////
            })
        })
    }

    // test() {

    // }

}
