import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { FavoritesService } from 'src/app/services/favorites.service';
import { ProductsService } from 'src/app/services/products.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-card',
    templateUrl: './card.component.html',
    styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

    @Input() product: any;

    user: any
    cart: any
    cartid: any
    faves: any

    constructor(private userService: UserService, private cartService: CartService, private favesService: FavoritesService, private router: Router) { }

    ngOnInit(): void {
        this.userService.getUserById(this.cartService.localUser.id).subscribe(data => {
            this.user = data
            this.cart = this.user.account.cart
            this.cartid = this.user.account.cart.id
            this.faves = this.user.account.favorites
            this.product.isFave = false

            ////////////////////////////////
            for (let i = 0; i < this.faves.products.length; i++) {
                let thisid = this.faves.products[i].id

                if (thisid == this.product.id) {
                    this.product.isFave = true;
                }
            }
            ////////////////////////////////
        })
    }

    addToCart() {
        let newCart

        this.cart.products.push(this.product)
        newCart = this.cart
        console.log(newCart)

        this.cartService.updateCart(this.cartid, newCart).subscribe(data => {})
    }

    addToFaves() {
        let newFaves

        this.faves.products.push(this.product)
        newFaves = this.faves
        this.favesService.updateFavorites(this.faves.id, newFaves).subscribe(data => {
            this.faves = data
        })

        // window.location.reload();
        if(window.location.href.includes("shop")) {
            this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
                this.router.navigate(['/shop']);
            });
        } else {
            this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
                this.router.navigate(['/selection/products']);
            });
        }
    }

    removeFromFaves() {
        let newFaves = this.faves
        let ids: Number[] = []

        for (let i = 0; i < this.faves.products.length; i++) {
            if (this.faves.products[i].id == this.product.id) {
                ids.push(i)
            }
        }

        newFaves.products.splice(ids[0], 1)
        this.favesService.updateFavorites(this.faves.id, newFaves).subscribe(data => { })

        // window.location.reload();
        if(window.location.href.includes("shop")) {
            this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
                this.router.navigate(['/shop']);
            });
        } else {
            this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
                this.router.navigate(['/selection/products']);
            });
        }
    }

}
