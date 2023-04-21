import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CartService } from 'src/app/services/cart.service';

@Component({
    selector: 'app-dialog-delete-from-cart',
    templateUrl: './dialog-delete-from-cart.component.html',
    styleUrls: ['./dialog-delete-from-cart.component.scss']
})
export class DialogDeleteFromCartComponent implements OnInit {

    constructor(private cartService: CartService, @Inject(MAT_DIALOG_DATA) public data: any) { }

    ngOnInit(): void {
    }

    onClickRemove() {
        let newCart = this.data.cart
        let filtered: any[] = []

        for (let i = 0; i < this.data.cart.products.length; i++) {
            if(this.data.cart.products[i].id != this.data.productid) {
                filtered.push(this.data.cart.products[i])
            }
        }

        newCart.products = filtered

        this.cartService.updateCart(this.data.cart.id, newCart).subscribe(data => {})

        window.location.reload();
    }

}
