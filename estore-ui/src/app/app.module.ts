import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductDetailComponent } from './screen/product-detail/product-detail.component';
import { SearchBarComponent } from './component/search-bar/search-bar.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatChipsModule } from '@angular/material/chips';
import { HeaderComponent } from './component/header/header.component';
import { SearchProductsComponent } from './screen/search-products/search-products.component';
import { LoginButtonComponent } from './component/login-button/login-button.component';
import { TagsListComponent } from './component/tags-list/tags-list.component';
import { LogoutComponent } from './screen/logout/logout.component';
import { ChipEditorComponent } from './component/chip-editor/chip-editor.component';
import { InventoryControlComponent } from './screen/inventory-control/inventory-control.component';
import { LoginComponent } from './screen/login/login.component';
import { JwtInterceptor } from './interceptor/jwt.interceptor';
import { BuyerInfosComponent } from './component/buyerInfos/buyerInfos.component';
import { BuyerInfoDetailComponent } from './component/buyerInfo-detail/buyerInfo-detail.component';
import { BrowseProductsComponent } from './screen/browse-products/browse-products.component';
@NgModule({
  declarations: [
    AppComponent,
    SearchBarComponent,
    ProductDetailComponent,
    BuyerInfosComponent,
    BuyerInfoDetailComponent,
    InventoryControlComponent,
    BrowseProductsComponent,
    LoginComponent,
    HeaderComponent,
    SearchProductsComponent,
    LoginButtonComponent,
    TagsListComponent,
    LogoutComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatSlideToggleModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatChipsModule,
    ChipEditorComponent,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
