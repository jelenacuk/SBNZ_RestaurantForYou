import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChartsModule } from 'ng2-charts';
import {
  MatButtonModule, MatInputModule, MatIconModule, MatCardModule, MatNativeDateModule,
  MatDatepickerModule, MatListModule, MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS,
  MatSelectModule, MatTooltipModule, MatToolbarModule, MatTabsModule, MatTableModule, MatPaginatorModule,
  MatMenuModule, MatExpansionModule, MatSortModule, MatAutocompleteModule, MatSlideToggleModule,
  MatRadioModule, MatDialogModule, MatCheckboxModule, MatChipsModule, MatOptionModule, MatDividerModule
} from '@angular/material';

const MatererialComponents = [
  MatButtonModule,
  MatInputModule,
  MatCardModule,
  MatIconModule,
  MatToolbarModule,
  MatChipsModule,
  MatPaginatorModule,
  MatOptionModule,
  MatSelectModule,
  MatCheckboxModule,
  MatListModule,
  MatDividerModule,
  MatRadioModule,
  ChartsModule,
  MatTabsModule,
  MatExpansionModule,
  MatTableModule,
  MatSnackBarModule
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
  providers: [{ provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: { duration: 2800, panelClass: ['snackBar'] } }]
})
export class MaterialModule { }
