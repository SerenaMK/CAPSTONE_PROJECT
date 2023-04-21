import { Component, Input, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-card-final',
    templateUrl: './card-final.component.html',
    styleUrls: ['./card-final.component.scss']
})
export class CardFinalComponent implements OnInit {

    @Input() product: any;

    user: any
    cart: any

    constructor(private userService: UserService, private orderService: OrderService) { }

    ngOnInit(): void {
        this.userService.getUserById(this.userService.localUser.id).subscribe(data => {
            this.user = data
            this.cart = this.user.account.cart

            // console.log(this.product);

            // this.favesid = this.user.account.favorites.id

            // this.favesService.getFavoritesById(this.favesid).subscribe(data => {
            //     this.faves = data
            // })
        })
    }

}
