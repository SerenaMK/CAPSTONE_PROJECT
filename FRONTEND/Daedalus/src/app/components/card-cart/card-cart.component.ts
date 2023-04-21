import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/user.service';
import { DialogDeleteFromCartComponent } from '../dialog-delete-from-cart/dialog-delete-from-cart.component';
import { DialogDeleteComponent } from '../dialog-delete/dialog-delete.component';

@Component({
    selector: 'app-card-cart',
    templateUrl: './card-cart.component.html',
    styleUrls: ['./card-cart.component.scss']
})
export class CardCartComponent implements OnInit {

    @Input() product: any;

    user: any
    userid: any
    cart: any
    cartid: any

    constructor(public dialog: MatDialog, private cartService: CartService, private userService: UserService) { }

    ngOnInit(): void {
        this.userid = this.cartService.localUser.id

        this.userService.getUserById(this.userid).subscribe(data => {
            this.user = data
            this.cartid = this.user.account.cart.id

            this.cartService.getCartById(this.cartid).subscribe(data => {
                this.cart = data
            })
        })
    }

    addOneToCart() {
        let newCart

        this.cart.products.push(this.product)

        newCart = this.cart

        this.cartService.updateCart(this.cartid, newCart).subscribe(data => {})

        window.location.reload();
    }

    removeOneFromCart() {
        let newCart = this.cart
        let ids: Number[] = []

        for (let i = 0; i < this.cart.products.length; i++) {
            if(this.cart.products[i].id == this.product.id) {
                ids.push(i)
            }
        }

        newCart.products.splice(ids[0], 1)

        this.cartService.updateCart(this.cartid, newCart).subscribe(data => {})

        window.location.reload();
    }

    openDialogRemoveFromCart(): void {
        this.dialog.open(DialogDeleteFromCartComponent, {
            width: '350px',
            data: {
                cart: this.cart,
                productid: this.product.id
            }
        });
    }

}
