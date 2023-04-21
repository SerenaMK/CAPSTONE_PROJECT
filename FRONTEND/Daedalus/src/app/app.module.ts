import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { CardComponent } from './components/card/card.component';
import { MatInputModule } from '@angular/material/input';
import { ShopComponent } from './components/shop/shop.component';
import { HighlightDirective } from './directives/highlight.directive';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { DetailComponent } from './components/detail/detail.component';
import { CartComponent } from './components/cart/cart.component';
import { ProfileComponent } from './components/profile/profile.component';
import { MatIconModule } from '@angular/material/icon';
import { FavoritesComponent } from './components/favorites/favorites.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { FooterComponent } from './components/footer/footer.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './components/admin/admin.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CardSmallComponent } from './components/card-small/card-small.component';
import { EditProductComponent } from './components/edit-product/edit-product.component';
import { UserCardComponent } from './components/user-card/user-card.component';
import { MatDialogModule } from '@angular/material/dialog';
import { DialogDeleteComponent } from './components/dialog-delete/dialog-delete.component';
import { ViewUserComponent } from './components/view-user/view-user.component';
import { CardCartComponent } from './components/card-cart/card-cart.component';
import { DialogDeleteFromCartComponent } from './components/dialog-delete-from-cart/dialog-delete-from-cart.component';
import { OrderHistoryComponent } from './components/order-history/order-history.component';
import { CardFavoriteComponent } from './components/card-favorite/card-favorite.component';
import { DialogDeleteFromFavesComponent } from './components/dialog-delete-from-faves/dialog-delete-from-faves.component';
import { OrderComponent } from './components/order/order.component';
import { CardOrderComponent } from './components/card-order/card-order.component';
import { CardFinalComponent } from './components/card-final/card-final.component';
import { SettingsComponent } from './components/settings/settings.component';
import { SelectionComponent } from './components/selection/selection.component';
import { SelAllComponent } from './components/sel-all/sel-all.component';
import { MatStepperModule } from '@angular/material/stepper';
import { MatRadioModule } from '@angular/material/radio';
import { MatChipsModule } from '@angular/material/chips';
import { SelectionProductsComponent } from './components/selection-products/selection-products.component';
import { MatTooltipModule } from '@angular/material/tooltip';

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        CardComponent,
        ShopComponent,
        HighlightDirective,
        HomeComponent,
        AboutComponent,
        DetailComponent,
        CartComponent,
        ProfileComponent,
        FavoritesComponent,
        FooterComponent,
        NotFoundComponent,
        AdminComponent,
        AddProductComponent,
        LoginComponent,
        RegisterComponent,
        UserListComponent,
        ProductListComponent,
        CardSmallComponent,
        EditProductComponent,
        UserCardComponent,
        DialogDeleteComponent,
        ViewUserComponent,
        CardCartComponent,
        DialogDeleteFromCartComponent,
        OrderHistoryComponent,
        CardFavoriteComponent,
        DialogDeleteFromFavesComponent,
        OrderComponent,
        CardOrderComponent,
        CardFinalComponent,
        SettingsComponent,
        SelectionComponent,
        SelAllComponent,
        SelectionProductsComponent
    ],
    imports: [
        FormsModule,
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatCardModule,
        MatButtonModule,
        MatInputModule,
        MatIconModule,
        MatSidenavModule,
        HttpClientModule,
        MatFormFieldModule,
        MatSelectModule,
        ReactiveFormsModule,
        MatDialogModule,
        MatStepperModule,
        MatRadioModule,
        MatChipsModule,
        MatTooltipModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
