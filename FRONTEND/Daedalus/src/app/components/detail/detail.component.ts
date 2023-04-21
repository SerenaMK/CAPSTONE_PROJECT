import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from 'src/app/services/cart.service';
import { FavoritesService } from 'src/app/services/favorites.service';
import { ProductsService } from 'src/app/services/products.service';
import { UserService } from 'src/app/services/user.service';
import {MatChipList} from '@angular/material/chips';

@Component({
    selector: 'app-detail',
    templateUrl: './detail.component.html',
    styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

    localUser: any = JSON.parse(localStorage.getItem("user")!)
    user: any
    cart: any
    cartid: any
    faves: any
    product: any
    identifier: number = parseInt(this.route.snapshot.paramMap.get("id")!)
    categories: any

    constructor(private productsService: ProductsService, private route: ActivatedRoute, private router: Router, private userService: UserService, private cartService: CartService, private favesService: FavoritesService) { }

    ngOnInit(): void {
        this.productsService.getProductById(this.identifier).subscribe(data => {
            this.product = data
            this.categories = this.product.categories

            console.log(this.categories);

            if(!this.identifier || this.product == undefined) {
                this.router.navigate(["/shop"])
            }
        })

        this.userService.getUserById(this.localUser.id).subscribe(data => {
            this.user = data
            this.cart = this.user.account.cart
            this.cartid = this.user.account.cart.id
            this.faves = this.user.account.favorites

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
        this.favesService.updateFavorites(this.faves.id, newFaves).subscribe(data => { })

        window.location.reload();
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

        window.location.reload();
    }

}
