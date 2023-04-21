import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductsService } from 'src/app/services/products.service';

@Component({
    selector: 'app-edit-product',
    templateUrl: './edit-product.component.html',
    styleUrls: ['./edit-product.component.scss']
})
export class EditProductComponent implements OnInit {

    product: any = {}
    identifier: number = parseInt(this.route.snapshot.paramMap.get("id")!)

    editForm!: FormGroup

    constructor(private productsService: ProductsService, private route: ActivatedRoute, private router: Router) { }

    ngOnInit(): void {
        this.productsService.getProductById(this.identifier).subscribe(data => {
            this.product = data
        })

        if (!this.identifier) {
            this.router.navigate(["/product-list"])
        }
    }

    ngDoCheck() {
        this.onLoad()
    }

    onSubmit() {
        this.product = {
            id: this.product.id,
            title: this.editForm.value.title,
            type: this.editForm.value.type,
            brand: this.editForm.value.brand,
            image: this.editForm.value.image,
            price: this.editForm.value.price,
            description: this.editForm.value.description,
            available: this.editForm.value.available
        }

        this.productsService.updateProduct(this.identifier, this.product).subscribe(data => console.log(data))
    }

    onLoad() {
        this.editForm = new FormGroup({
            title: new FormControl(this.product.title, Validators.required),
            type: new FormControl(this.product.type, [Validators.required, Validators.maxLength(20)]),
            brand: new FormControl(this.product.brand, [Validators.required, Validators.maxLength(20)]),
            image: new FormControl(this.product.image, Validators.required),
            price: new FormControl(this.product.price, [Validators.required, Validators.maxLength(20)]),
            description: new FormControl(this.product.description, Validators.required),
            available: new FormControl(`${this.product.available}`, Validators.required)
        })
    }

}
