import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './screen/product-detail/product-detail.component';
import { InventoryControlComponent } from './screen/inventory-control/inventory-control.component';
import { BrowseProductsComponent } from './screen/browse-products/browse-products.component';
import { LoginComponent } from './screen/login/login.component';
import { SearchProductsComponent } from './screen/search-products/search-products.component';
import { LogoutComponent } from './screen/logout/logout.component';
import { BuyerInfosComponent } from './component/buyerInfos/buyerInfos.component';
import { BuyerInfoDetailComponent } from './component/buyerInfo-detail/buyerInfo-detail.component';
import { SignupComponent } from './screen/signup/signup.component';
import { CartInfoComponent } from './component/cart-info/cart-info.component';

const routes: Routes = [
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'inventory', component: InventoryControlComponent },
  { path: 'products', component: BrowseProductsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'search', component: SearchProductsComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'accounts', component: BuyerInfosComponent },
  { path: 'account/:id', component: BuyerInfoDetailComponent },
  { path: 'cart', component: CartInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
