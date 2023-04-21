import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CartService } from 'src/app/services/cart.service';
import { FavoritesService } from 'src/app/services/favorites.service';
import { UserService } from 'src/app/services/user.service';
import { DialogDeleteFromFavesComponent } from '../dialog-delete-from-faves/dialog-delete-from-faves.component';

@Component({
    selector: 'app-card-favorite',
    templateUrl: './card-favorite.component.html',
    styleUrls: ['./card-favorite.component.scss']
})
export class CardFavoriteComponent implements OnInit {

    @Input() product: any;

    user: any
    cart: any
    faves: any
    favesid: any

    constructor(public dialog: MatDialog, private favesService: FavoritesService, private userService: UserService, private cartService: CartService) { }

    ngOnInit(): void {
        this.userService.getUserById(this.userService.localUser.id).subscribe(data => {
            this.user = data
            this.cart = this.user.account.cart
            this.favesid = this.user.account.favorites.id

            this.favesService.getFavoritesById(this.favesid).subscribe(data => {
                this.faves = data
            })
        })
    }

    addOneToCart() {
        let newCart

        this.cart.products.push(this.product)

        newCart = this.cart

        this.cartService.updateCart(this.cart.id, newCart).subscribe(data => {})

        window.location.reload();
    }

    openDialogRemoveFromFaves(): void {
        this.dialog.open(DialogDeleteFromFavesComponent, {
            width: '350px',
            data: {
                faves: this.faves,
                productid: this.product.id
            }
        });
    }

}
