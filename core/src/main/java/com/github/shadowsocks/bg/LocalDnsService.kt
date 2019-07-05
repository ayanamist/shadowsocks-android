/*******************************************************************************
 *                                                                             *
 *  Copyright (C) 2017 by Max Lv <max.c.lv@gmail.com>                          *
 *  Copyright (C) 2017 by Mygod Studio <contact-shadowsocks-android@mygod.be>  *
 *                                                                             *
 *  This program is free software: you can redistribute it and/or modify       *
 *  it under the terms of the GNU General Public License as published by       *
 *  the Free Software Foundation, either version 3 of the License, or          *
 *  (at your option) any later version.                                        *
 *                                                                             *
 *  This program is distributed in the hope that it will be useful,            *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              *
 *  GNU General Public License for more details.                               *
 *                                                                             *
 *  You should have received a copy of the GNU General Public License          *
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.       *
 *                                                                             *
 *******************************************************************************/

package com.github.shadowsocks.bg

import com.github.shadowsocks.Core
import com.github.shadowsocks.net.HostsFile
import com.github.shadowsocks.preference.DataStore
import com.github.shadowsocks.utils.Key
import kotlinx.coroutines.CoroutineScope
import java.io.File

object LocalDnsService {
    interface Interface : BaseService.Interface {
        override suspend fun startProcesses(hosts: HostsFile) {
            File(Core.deviceStorage.getExternalFilesDir(null), "hosts")
                    .writeText(DataStore.publicStore.getString(Key.hosts) ?: "")
            super.startProcesses(hosts)
        }

        override fun killProcesses(scope: CoroutineScope) {
            super.killProcesses(scope)
        }
    }
}
