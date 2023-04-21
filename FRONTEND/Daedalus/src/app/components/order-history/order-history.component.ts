import { Component, OnInit } from '@angular/core';
import { OrderHistoryService } from 'src/app/services/order-history.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-order-history',
    templateUrl: './order-history.component.html',
    styleUrls: ['./order-history.component.scss']
})
export class OrderHistoryComponent implements OnInit {

    user: any
    orderHistory: any
    orders: any

    constructor(private userService: UserService, private ohService: OrderHistoryService) { }

    ngOnInit(): void {
        this.userService.getUserById(this.userService.localUser.id).subscribe(data => {
            this.user = data

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

}
