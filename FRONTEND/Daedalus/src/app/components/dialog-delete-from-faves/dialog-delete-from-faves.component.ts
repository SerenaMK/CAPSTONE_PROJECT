import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FavoritesService } from 'src/app/services/favorites.service';

@Component({
    selector: 'app-dialog-delete-from-faves',
    templateUrl: './dialog-delete-from-faves.component.html',
    styleUrls: ['./dialog-delete-from-faves.component.scss']
})
export class DialogDeleteFromFavesComponent implements OnInit {

    constructor(private favesService: FavoritesService, @Inject(MAT_DIALOG_DATA) public data: any) { }

    ngOnInit(): void {
    }

    onClickRemove() {
        let newFaves = this.data.faves
        let filtered: any[] = []

        for (let i = 0; i < this.data.faves.products.length; i++) {
            if(this.data.faves.products[i].id != this.data.productid) {
                filtered.push(this.data.faves.products[i])
            }
        }

        newFaves.products = filtered

        this.favesService.updateFavorites(this.data.faves.id, newFaves).subscribe(data => {})

        window.location.reload();
    }

}
