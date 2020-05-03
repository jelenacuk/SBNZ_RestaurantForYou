import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatButtonModule, MatInputModule, MatIconModule, MatCardModule, MatNativeDateModule,
  MatDatepickerModule, MatListModule, MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS,
  MatSelectModule, MatTooltipModule, MatToolbarModule, MatTabsModule, MatTableModule, MatPaginatorModule,
  MatMenuModule, MatExpansionModule, MatSortModule, MatAutocompleteModule, MatSlideToggleModule,
  MatRadioModule, MatDialogModule, MatCheckboxModule
} from '@angular/material';

const MatererialComponents = [
  MatButtonModule,
  MatInputModule,
  MatCardModule,
  MatIconModule
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatererialComponents
  ],
  exports: [
    MatererialComponents
  ],
  providers: []
})
export class MaterialModule { }
