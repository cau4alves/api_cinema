import { Injectable, NotFoundException } from '@nestjs/common';
import { PrismaService } from 'src/prisma/prisma.service';
import { CreateUserDTO } from './dto/create-user.dto';

@Injectable()
export class UserService {
    constructor(private prisma: PrismaService) {}

    async listAll() {
        const users = await this.prisma.user.findMany()
        return users
    }

    async findOne(id: string) {
        const user = await this.prisma.user.findFirst({
            where: {
                id: id
            }
        })

        if(!user) {
            throw new NotFoundException('Nenhum usuário encontrado')
        }

        return user
    }

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
