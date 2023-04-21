import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProductsService } from 'src/app/services/products.service';

@Component({
    selector: 'app-dialog-delete',
    templateUrl: './dialog-delete.component.html',
    styleUrls: ['./dialog-delete.component.scss']
})
export class DialogDeleteComponent implements OnInit {

    constructor(private productService: ProductsService, @Inject(MAT_DIALOG_DATA) public data: any) { }

    ngOnInit(): void {
    }

    onClickDelete() {
        this.productService.deleteProduct(this.data.id).subscribe(data => {})
        window.location.reload()
    }

}
