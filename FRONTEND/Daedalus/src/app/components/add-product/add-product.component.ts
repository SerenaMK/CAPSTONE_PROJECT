import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductsService } from 'src/app/services/products.service';

@Component({
    selector: 'app-add-product',
    templateUrl: './add-product.component.html',
    styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

    product: any = {}

    addForm!: FormGroup

    constructor(private productsService: ProductsService) { }

    ngOnInit(): void {
        this.addForm = new FormGroup({
            title: new FormControl(null, Validators.required),
            type: new FormControl(null, [ Validators.required, Validators.maxLength(20) ]),
            brand: new FormControl(null, [ Validators.required, Validators.maxLength(20) ]),
            image: new FormControl("https://lh3.googleusercontent.com/hzTpTV1Qwyi4crcaB_lEaRTg603ttzm_6Uw8SwBC-iQ9-PeWdFdNpejyPzFdVqWLBjf8o58sDjs8M9wV01MCyjJ3XX6GBIiUrLRiQi9ui8m0tp0=e365-rw-v0-w400", Validators.required),
            price: new FormControl(null, [ Validators.required, Validators.maxLength(20) ]),
            description: new FormControl(null, Validators.required),
            available: new FormControl("true", Validators.required)
        })
    }

    onSubmit() {
        this.product = {
            title: this.addForm.value.title,
            type: this.addForm.value.type,
            brand: this.addForm.value.brand,
            image: this.addForm.value.image,
            price: this.addForm.value.price,
            description: this.addForm.value.description,
            available: this.addForm.value.available
        }

        this.productsService.addProduct(this.product).subscribe(data => console.log(data))
    }

}
