import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderHistoryService } from 'src/app/services/order-history.service';
import { OrderService } from 'src/app/services/order.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-order',
    templateUrl: './order.component.html',
    styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

    identifier: number = parseInt(this.route.snapshot.paramMap.get("id")!)
    order: any
    products: any
    total: any = 0

    constructor(private userService: UserService, private ohService: OrderHistoryService, private orderService: OrderService, private route: ActivatedRoute) { }

    ngOnInit(): void {
        this.orderService.getOrderById(this.identifier).subscribe(data => {
            this.order = data
            this.products = this.order.products

            ////////////////////////////////
            let filtered: string | any[] = []
            let ids: number [] = []
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
                        if(filtered[i].id == thisid) {
                            theOne = i
                        }
                    }

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

}
