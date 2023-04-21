import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogDeleteComponent } from '../dialog-delete/dialog-delete.component';

@Component({
    selector: 'app-card-small',
    templateUrl: './card-small.component.html',
    styleUrls: ['./card-small.component.scss']
})
export class CardSmallComponent implements OnInit {

    @Input() product: any;

    constructor(public dialog: MatDialog) { }

    ngOnInit(): void {

    }

    openDialog(): void {
        this.dialog.open(DialogDeleteComponent, {
            width: '350px',
            data: {
                id: this.product.id
            }
        });
    }
}
