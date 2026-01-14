import { Injectable } from '@nestjs/common';
import { PrismaService } from 'src/prisma/prisma.service';
import { CreateUserDTO } from './dto/create-user.dto';

@Injectable()
export class UserService {
    constructor(private prisma: PrismaService) {}

    async createUser(body: CreateUserDTO) {
        const user = await this.prisma.user.create({
            data: {
                username: body.username,
                email: body.email,
                password: body.password,
            }
        })

        return user
    }
}
