import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
    selector: 'app-selection-products',
    templateUrl: './selection-products.component.html',
    styleUrls: ['./selection-products.component.scss']
})
export class SelectionProductsComponent implements OnInit {

    products: any[] = []

    constructor(private productsService: ProductsService) { }

    ngOnInit(): void {
        this.products = this.productsService.selection

        console.log(this.products);
    }

}
