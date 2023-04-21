import { Component, Input, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-card-order',
    templateUrl: './card-order.component.html',
    styleUrls: ['./card-order.component.scss']
})
export class CardOrderComponent implements OnInit {

    @Input() order: any;

    user: any
    orderHistory: any
    total: any = 0

    constructor(private userService: UserService) { }

    ngOnInit(): void {
        this.userService.getUserById(this.userService.localUser.id).subscribe(data => {
            this.user = data

            for (let i = 0; i < this.order.products.length; i++) {
                this.total += this.order.products[i].price;
            }
        })
    }

}
