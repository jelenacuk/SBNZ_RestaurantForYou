import { ReportDTO } from './report-dto';
import { FeaturesDTO } from './features-dto';

export class RestaurantDto {

    id: string;
    name: string;
    description: string;
    number: string;
    image: string;
    capacity: string;
    kitchen: string;
    music: string;
    ambience: string;
    price: string;
    street: string;
    latitude: number;
    longitude: number;
    size: number;
    reportDTO: ReportDTO;
    features: FeaturesDTO;
    grade: number;
    alarmCreation: Date;
    averageGrade: number;

}
