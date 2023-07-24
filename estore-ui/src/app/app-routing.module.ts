import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductDetailComponent } from './screen/product-detail/product-detail.component';
import { InventoryControlComponent } from './inventory-control/inventory-control.component';
import { BrowseProductsComponent } from './component/browse-products/browse-products.component';
import { LoginComponent } from './screen/login/login.component';
import { BuyerInfosComponent } from './component/buyerInfos/buyerInfos.component';
import { BuyerInfoDetailComponent } from './component/buyerInfo-detail/buyerInfo-detail.component';

const routes: Routes = [
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'inventory', component: InventoryControlComponent },
  { path: 'products', component: BrowseProductsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'account', component: BuyerInfosComponent },
  { path: 'account/:id', component: BuyerInfoDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
