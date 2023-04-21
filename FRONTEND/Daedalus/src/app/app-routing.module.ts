import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { AdminComponent } from './components/admin/admin.component';
import { CartComponent } from './components/cart/cart.component';
import { DetailComponent } from './components/detail/detail.component';
import { EditProductComponent } from './components/edit-product/edit-product.component';
import { FavoritesComponent } from './components/favorites/favorites.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { OrderHistoryComponent } from './components/order-history/order-history.component';
import { OrderComponent } from './components/order/order.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { SelectionProductsComponent } from './components/selection-products/selection-products.component';
import { SelectionComponent } from './components/selection/selection.component';
import { SettingsComponent } from './components/settings/settings.component';
import { ShopComponent } from './components/shop/shop.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { ViewUserComponent } from './components/view-user/view-user.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
    {
        path: "",
        component: HomeComponent
    },
    {
        path: "register",
        component: RegisterComponent
    },
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: "about",
        component: AboutComponent
    },
    {
        path: "selection",
        component: SelectionComponent
    },
    {
        path: "selection/products",
        component: SelectionProductsComponent
    },
    {
        path: "shop",
        component: ShopComponent
    },
    {
        path: "detail",
        component: DetailComponent
    },
    {
        path: "detail/:id",
        component: DetailComponent
    },
    {
        path: "profile",
        component: ProfileComponent
    },
    {
        path: "cart",
        component: CartComponent
    },
    {
        path: "favorites",
        component: FavoritesComponent
    },
    {
        path: "order-history",
        component: OrderHistoryComponent
    },
    {
        path: "order",
        component: OrderComponent
    },
    {
        path: "order/:id",
        component: OrderComponent
    },
    {
        path: "admin",
        canActivate: [AuthGuard],
        component: AdminComponent
    },
    {
        path: "settings",
        component: SettingsComponent
    },
    {
        path: "add-product",
        component: AddProductComponent
    },
    {
        path: "edit-product",
        component: EditProductComponent
    },
    {
        path: "edit-product/:id",
        component: EditProductComponent
    },
    {
        path: "view-user",
        component: ViewUserComponent
    },
    {
        path: "view-user/:id",
        component: ViewUserComponent
    },
    {
        path: "user-list",
        component: UserListComponent
    },
    {
        path: "product-list",
        component: ProductListComponent
    },
    {
        path: "404",
        component: NotFoundComponent
    },
    {
        path: "signup",
        redirectTo: "/register"
    },
    {
        path: "signin",
        redirectTo: "/login"
    },
    {
        path: "**", // da usare solo in fondo a tutti gli altri
        redirectTo: "/404"
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
