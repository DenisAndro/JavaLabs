<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    background-color: #E6F7FF;
                    color: #333;
                    margin: 0;
                    padding: 20px;
                    }
                    h1 {
                    color: #0077B6;
                    text-align: center;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 20px;
                    background-color: #FFFFFF;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    }
                    th, td {
                    padding: 12px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                    }
                    th {
                    background-color: #0077B6;
                    color: white;
                    }
                    tr:hover {
                    background-color: #f1f1f1;
                    }
                    .no-data {
                    text-align: center;
                    color: #777;
                    padding: 20px;
                    }
                </style>
            </head>
            <body>
                <h1>Проекты</h1>
                <xsl:choose>
                    <xsl:when test="projects/project">
                        <table>
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Имя</th>
                                    <th>Описание</th>
                                    <th>Дата начала</th>
                                    <th>Дата окончания</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="projects/project">
                                    <tr>
                                        <td><xsl:value-of select="@id"/></td>
                                        <td><xsl:value-of select="@name"/></td>
                                        <td><xsl:value-of select="@description"/></td>
                                        <td><xsl:value-of select="@startDate"/></td>
                                        <td><xsl:value-of select="@endDate"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </xsl:when>
                    <xsl:otherwise>
                        <div class="no-data">Нет данных о проектах.</div>
                    </xsl:otherwise>
                </xsl:choose>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>