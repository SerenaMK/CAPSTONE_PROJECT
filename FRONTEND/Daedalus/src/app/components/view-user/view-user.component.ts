import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-view-user',
    templateUrl: './view-user.component.html',
    styleUrls: ['./view-user.component.scss']
})
export class ViewUserComponent implements OnInit {

    user: any
    identifier: number = parseInt(this.route.snapshot.paramMap.get("id")!)
    products: any

    constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.userService.getUserById(this.identifier).subscribe(data => {
            this.user = data

            console.log("USER OBJECT:")
            console.log(this.user)

            if(!this.identifier || this.user == undefined) {
                this.router.navigate(["/user-list"])
            }

            console.log("THIS USER'S CART:")
            console.log(this.user.account.cart)

            this.products = this.user.account.cart.products;

            // for (let i = 0; i < this.user.account.cart.products.length; i++) {
            //     this.user.account.cart.products[i];
            // }
        })
    }

    test() {
        // this.user.account.cart.products = [
        //     {
        //         hey: "ciao"
        //     },
        //     {
        //         hey: "salve"
        //     }
        // ]
    }

}
