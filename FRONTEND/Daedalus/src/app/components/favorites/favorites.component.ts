import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-favorites',
    templateUrl: './favorites.component.html',
    styleUrls: ['./favorites.component.scss']
})
export class FavoritesComponent implements OnInit {

    user: any
    products: any = []
    total: number = 0

    constructor(private userService: UserService, private productService: ProductsService) { }

    ngOnInit(): void {

        this.userService.getUserById(this.userService.localUser.id).subscribe(data => {
            this.user = data
            this.products = this.user.account.favorites.products
        })
    }

}
